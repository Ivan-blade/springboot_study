+ 参考https://blog.csdn.net/xiaocy66/article/details/82875770
+ 安装jdk并且配置环境变量
+ 下载maven并且配置环境变量
+ 配置maven
    + 编辑conf下的setting.xml
        ```
            在第55行加上
            <localRepository>F:/springboot_project/project_one</localRepository>
            标签中间的为新建文件路径（作为仓库）
        ```
+ vscode安装扩展包
    + Chinese (Simplified) Language Pack for Visual Studio Code(中文扩展包)
    + Atom One Dark Theme(这是个花里胡哨的主题包--我跟你说除了好看其它的都是扯淡)
    + Java Extension Pack(java扩展包)
+ 一系列配置
    + 在vscode设置中搜索maven
        + 在setting.json中增加maven的可执行文件路径配置、maven的setting路径配置、java.home的路径配置
            ```
                "java.home":"C:\\Program Files\\Java\\jdk1.8.0_131",
                "java.configuration.maven.userSettings": "E:\\apache-maven-3.6.2-bin\\apache-maven-3.6.2\\conf\\settings.xml",
                "maven.executable.path": "E:\\apache-maven-3.6.2-bin\\apache-maven-3.6.2\\bin\\mvn.cmd",
                "maven.terminal.useJavaHome": true,
                "maven.terminal.customEnv": [
                    {
                        "environmentVariable": "JAVA_HOME",
                        "value": "C:\\Program Files\\Java\\jdk1.8.0_131"
                    }
                ]
            ```
        + 使用阿里云镜像
            ```
                在maven目录conf下的setting.xml的mirror部分添加如下内容
                <mirror>
                    <id>alimaven</id>
                    <name>aliyun maven</name>
                    <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
                    <mirrorOf>central</mirrorOf>
                </mirror>
            ```
+ 生成maven项目
    + ctrl + shift + p
    + 输入Spring搜索后选择maven类型
    + 语言java,groud id和artificated id默认
    + 依赖单击选择DevTools（代码修改热更新，无需重启）、Web（集成tomcat、SpringMVC）、Lombok（智能生成setter、getter、toString等接口，无需手动生成，代码更简介）
    + 选择项目后等待生成完毕open
    + 点击vscode左侧调试图标，点击添加配置...等待vscode下载好依赖包之后程序将会执行