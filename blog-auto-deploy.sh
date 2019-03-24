#/bin/bash

# 代码分支
export branch="master"

# 项目工作目录
export workDir=""

# 是否自动删除代码
export autoDelete=false

stopContainer(){
    if [ -a docker.cid ]; then
        export cid=""
        echo "\033[1;35m 1、获取容器ID \033[0m"
        echo "\033[1;34m #> cid=`cat docker.cid` \033[0m"
        cid=`cat docker.cid`
        echo ""

        echo "\033[1;35m 2、停止容器 \033[0m"
        echo "\033[1;34m #> docker container stop $cid \033[0m"
        docker container stop $cid
        echo ""

        echo "\033[1;35m 3、删除容器ID文件 \033[0m"
        echo "\033[1;34m #> rm -f docker.cid \033[0m"
        rm -f docker.cid
        echo ""
    fi
}

# 从github上下载代码
downloadCode(){
    echo "\033[1;35m 1、开始下载代码 \033[0m"
    echo "\033[1;34m #> git clone https://github.com/greenfit/heleeos.com.git \033[0m"
    git clone https://github.com/greenfit/heleeos.com.git
    echo ""

    echo "\033[1;35m 2、切换到代码目录 \033[0m"
    echo "\033[1;34m #> cd heleeos.com \033[0m"
    cd heleeos.com
    workDir=$(pwd)
    echo ""

    echo "\033[1;35m 3、切换到指定分支 \033[0m"
    echo "\033[1;34m #> git checkout $branch \033[0m"
    git checkout $branch
    echo "\033[1;34m #> git pull \033[0m"
    git pull
    echo ""
}

# 部署代码
buildServer(){
    serverDir="$workDir/blog-server"
    console.log($serverDir)
    if [ -a $serverDir ]; then
        echo "\033[1;35m 1、切换到工作目录 \033[0m"
        echo "\033[1;34m #> cd $serverDir \033[0m"
        cd $serverDir
        echo ""

        echo "\033[1;35m 2、打包服务代码 \033[0m"
        echo "\033[1;34m #> mvn clean build -Dmaven.test.skip \033[0m"
        mvn clean install -U -Dmaven.test.skip
        echo ""
    fi
}

# 部署管理层前端代码
buildManager(){
    managerDir="$workDir/blog-manager"
    if [ -a $managerDir ]; then
        echo "\033[1;35m 1、切换到工作目录 \033[0m"
        echo "\033[1;34m #> cd $managerDir \033[0m"
        cd $managerDir
        echo ""

        echo "\033[1;35m 2、安装依赖包 \033[0m"
        echo "\033[1;34m #> npm install \033[0m"
        npm install
        echo ""

        echo "\033[1;35m 3、打包前端代码 \033[0m"
        echo "\033[1;34m #> npm run build \033[0m"
        npm run build
        echo ""
    fi
}

# 打包 docker 镜像文件
buildDockerImage(){
    echo "\033[1;35m 1、切换到工作目录 \033[0m"
    echo "\033[1;34m #> cd $workDir \033[0m"
    cd $workDir
    echo ""

    echo "\033[1;35m 2、打包镜像文件 \033[0m"
    echo "\033[1;34m #> docker image build -t blog.heleeos.com . \033[0m"
    docker image build -t blog.heleeos.com .
}

# 运行 docker 镜像文件
runDockerImage(){
    # run image
    echo "\033[1;35m 1、执行镜像 \033[0m"
    echo "#> docker run -it -d -p 5000:80 blog.heleeos.com java -jar /app/heleeos-service.jar > docker.cid"
    docker run -it -d -p 5000:80 blog.heleeos.com java -jar /app/heleeos-service.jar > docker.cid
}

# 删除代码
deleteCode(){
    if ( $autoDelete ); then
        echo "\033[1;35m 1、删除代码 \033[0m"
        echo "\033[1;34m rm -rf $workDir \033[0m"
        # rm -rf $workDir
    fi
}

usage(){
    echo "用户:"
    echo "    blog.auto-deploy.sh [-b BRANCH] [-d]"
    echo "说明:"
    echo "    -b BRANCH, 指定需要自动部署的分支."
    echo "    -d,        部署后自动删除下载的代码内容."
    exit -1
}

while getopts 'b:hd' OPT; do
    case $OPT in
        b) branch="$OPTARG";;
        d) autoDelete=true;;
        h) usage;;
        ?) usage;;
    esac
done

stopContainer
downloadCode
buildServer
buildManager
buildDockerImage
runDockerImage
deleteCode