# springboot_study
### 学习网站
+ <a href="https://www.w3cschool.cn/wkspring/">w3cschool</a>
  + <a href="https://www.w3cschool.cn/minicourse/play/springbootrm">w3c视频教程</a>
 + <a href="https://www.runoob.com/">菜鸟教程</a>

### unknown
+ 热部署
    ```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
    ```
+ 默认依赖存储
  + 在maven的conf中的setting.xml文件里添加如下配置
    ```
      <localRepository>F:/springboot_project/respository</localRepository>
    ```
+ IDEA配置
  + 在setting中选择build -> build tools -> Maven对最后三项做配置，分别是maven路径，maven的setting.xml路径和依赖存储路径

+ 上传项目到github时忽略一些idea专用文件
  + 在setting中的plugin下载.ignore文件
  + 右击项目新建gitignore文件,选择默认模板加上.gitignore文件

+ 上传文件到github
  + 主要VCS里面点点，idea实在不行，终端连linux命令都跑不了ide还不如vscode一个编辑器，一代码农，身在曹营心在汉
### start
  + yml语法
    + 变量赋值不需要引号
    + 如果加上引号，双引号会对特殊字符进行转义，单引号不会
  + 粮草未动，日志先行
    + slf4j(日志抽象层)
    + logback（日志实现）
    + 配置(见test主函数，yml和pro配置文件)
    + 修改日志文件生成路径
      + logging.file.name（文件名）
      + logging.file.path（文件路径）
      + 两者都不设置，日志只会在控制台输出
      + 只设置name，不设置path，项目根目录会自动生成记录日志的名为file的文件
      + 不设置name，只设置path，日志会生成在磁盘根目录下的path路径下的spring.log中
      + 都设置日志会出现在对应目录下的对应文件中