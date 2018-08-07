import Vue from 'vue';
import iView from 'iview';
import Util from '../libs/util';
import VueRouter from 'vue-router';
import Cookies from 'js-cookie';
import {routers, otherRouter, appRouter} from './router';

Vue.use(VueRouter);

// 路由配置
const RouterConfig = {
    routes: routers
};

export const router = new VueRouter(RouterConfig);

/**
 * 获取登录的管理员
 */
function getManager() {
    var managerInfo = localStorage.getItem("managerInfo");
    if(managerInfo === undefined) return undefined;
    return JSON.parse(managerInfo);
}

function toPage(routers, name, route, next) {
    let len = routers.length;
    let i = 0;
    let notHandle = true;
    while (i < len) {
        if (routers[i].name === name && routers[i].children && routers[i].redirect === undefined) {
            route.replace({ name: routers[i].children[0].name });
            notHandle = false;
            next();
            break;
        }
        i++;
    }
    if (notHandle) {
        next();
    }
};


router.beforeEach((to, from, next) => {
    iView.LoadingBar.start();
    Util.setTitle(to.meta.title);
    var manager = getManager();
    //1. 锁屏
    if (Cookies.get('locking') === '1' && to.name !== 'locking') { // 判断当前是否是锁定状态
        Util.logger("route - index.js - locking");
        next({ replace: true, name: 'locking'});
    } else if (Cookies.get('locking') === '0' && to.name === 'locking') {
        Util.logger("route - index.js - nowLocking");
        next(false);
    }else {
        if(!manager) {
            Util.logger("route - index.js - toLogin");
            if(to.name != 'login') {
                next({ name: 'login' });
            }
        } else {
            //Util.logger("manager:" + JSON.stringify(manager));
            localStorage.setItem("token", manager.loginToken);
            if(to.name === 'login') {
                Util.title();
                next({name: 'home_index'});
            } else {
                const curRouterObj = Util.getRouterObjByName([otherRouter, ...appRouter], to.name);
                if (curRouterObj && curRouterObj.access !== undefined) { // 需要判断权限的路由
                    if (curRouterObj.access === parseInt(Cookies.get('access'))) {
                        Util.toDefaultPage([otherRouter, ...appRouter], to.name, router, next); // 如果在地址栏输入的是一级菜单则默认打开其第一个二级菜单的页面
                    } else {
                        next({
                            replace: true,
                            name: 'error-403'
                        });
                    }
                } else { // 没有配置权限的路由, 直接通过
                    Util.toDefaultPage([...routers], to.name, router, next);
                }
            }
        }
    }

    toPage([...routers], to.name, router, next);
});

router.afterEach((to) => {
    Util.openNewPage(router.app, to.name, to.params, to.query);
    iView.LoadingBar.finish();
    window.scrollTo(0, 0);
});
