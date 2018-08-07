import Main from '@/views/Main.vue';

// 不作为Main组件的子页面展示的页面单独写，如下
export const loginRouter = {
    path: '/login',
    name: 'login',
    meta: {
        title: 'Login - 登录'
    },
    component: () => import('@/views/login.vue')
};

export const page404 = {
    path: '/*',
    name: 'error-404',
    meta: {
        title: '404-页面不存在'
    },
    component: () => import('@/views/error-page/404.vue')
};

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: () => import('@//views/error-page/403.vue')
};

export const locking = {
    path: '/locking',
    name: 'locking',
    component: () => import('@/views/main-components/lockscreen/components/locking-page.vue')
};

// 作为Main组件的子页面展示但是不在左侧菜单显示的路由写在otherRouter里
export const otherRouter = {
    path: '/',
    name: 'otherRouter',
    redirect: '/home',
    component: Main,
    children: [
        { path: 'home', title: '首页', name: 'home_index', component: () => import('@/views/home/home.vue') },
        { path: 'ownspace', title: '个人中心', name: 'ownspace_index', component: () => import('@/views/own-space/own-space.vue') },
        { path: 'message', title: '消息中心', name: 'message_index', component: () => import('@/views/message/message.vue') },
        { path: 'preview', title: '预览', name: 'preview', component: () => import('@/views/blog-manager/preview.vue')}
    ]
};

// 作为Main组件的子页面展示并且在左侧菜单显示的路由写在appRouter里
export const appRouter = [
    {
        path: '/system-info',
        icon: 'information-circled',
        name: 'system-info',
        title: '系统信息',
        component: Main,
        children: [
            { path: 'server-info', title: '服务器信息', name: 'server-info', icon: 'social-tux' },
            { path: 'application-info', title: '应用信息', name: 'application-info', icon: 'android-apps'}
        ]
    },
    {
        path: '/blog-manager',
        icon: 'document',
        name: 'blog-manager',
        title: '博客管理',
        component: Main,
        children: [
            { path: 'blog-publish', title: '文章发布', name: 'blog-publish', icon: 'compose', component: () => import('@/views/blog-manager/blog-publish.vue') },
            { path: 'blog-list', title: '文章列表', name: 'blog-list', icon: 'ios-list', component: () => import('@/views/blog-manager/blog-list.vue') },
            { path: 'blog-flow', title: '文章审核', name: 'blog-flow', icon: 'arrow-swap', component: () => import('@/views/blog-manager/blog-flow.vue') }
        ]
    },
    {
        path: '/topic-manager',
        icon: 'arrow-graph-up-right',
        name: 'topic-manager',
        title: '话题管理',
        component: Main,
        children: [
            { path: 'topic-square', title: '话题广场', name: 'topic-square', icon: 'radio-waves', component: () => import('@/views/topic-manager/topic-square.vue') },
            { path: 'topic-publish', title: '发布话题', name: 'topic-publish', icon: 'ios-cloud-upload-outline', component: () => import('@/views/topic-manager/topic-publish.vue') }
        ]
    }
];

// 所有上面定义的路由都要写在下面的routers里
export const routers = [
    loginRouter,
    otherRouter,
    locking,
    ...appRouter,
    page403,
    page404
];
