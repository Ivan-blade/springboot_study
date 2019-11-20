+ 默认全局配置文件
    + application.properties 
        ```
            server.port = 8888
        ```
    + application.yml
        ```
            通过缩进表示嵌套关系，冒号后如果有值需要加空格
            server:
                port: 8888
        ```
    + 以上两者都可以为类的对象赋值但是类文件需要两个注解
        ```
            @Component
            @ConfigurationProperties(prefix="nickname")
            public class student {
                ....
            }
            .yml中
            nickname:
                name: zs
                set: 
                    - xxx
                    - xxx
                list:
                    - xxx
                    - xxx
                map: {key1: 1,key2: 2} 
        ```
+ 启动方式
    + 编译器内run
    + 在项目文件夹下
        ```
            mvn spring-boot:run
        ```
    + 部署到服务器中
        ```
            mvn clear package
            java -jar target/xxx.jar
        ```
+ 基本概念
    + bean
        <p>javabean简单的讲就是实体类，用来封装对象，这个类里面全部都是属性值，和get，set方法。</p>
+ 注解(参考http://blog.csdn.net/weixin_39805338/article/details/80770472)
    + @GetMapping("/path")
        <p>内容在某路径下生效</p>
    + @Value("${xxx}")在配置文件properties中对xxx进行赋值
        ```
            @Value("${now}")
            private String now;
        ```
    + @PostConstruct 和 @PreDestory 
        <p>实现初始化和销毁bean之前进行的操作，只能有一个方法可以用此注释进行注释，方法不能有参数，返回值必需是void,方法需要是非静态的。</p>
    + @Autowired
        <p>
            Autowired默认先按byType，如果发现找到多个bean，则，又按照byName方式比对，如果还有多个，则报出异常。
            1.可以手动指定按byName方式注入，使用@Qualifier。
            //通过此注解完成从spring配置文件中 查找满足Fruit的bean,然后按//@Qualifier指定pean
            @Autowired
            @Qualifier(“pean”)
            public Fruit fruit;
            2.如果要允许null 值，可以设置它的required属性为false，如：@Autowired(required=false) 
            public Fruit fruit;
        </p>
    + @Lazy(true)
        <p>用于指定该Bean是否取消预初始化，用于注解类，延迟初始化</p>
    + @Primary
        <p>自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常</p>
    + @Resource
        <pre>
            默认按 byName(id)自动注入,如果找不到再按byType(class)找bean,如果还是找不到则抛异常，无论按byName还是byType如果找到多个，则抛异常。
            可以手动指定bean,它有2个属性分别是name和type，使用name属性，则使用byName的自动注入，而使用type属性时则使用byType自动注入。
            @Resource(name=”bean名字”)
            或
            @Resource(type=”bean的class”)
            这个注解是属于J2EE的，减少了与spring的耦合。
        </pre>
    + @Async
        <pre>
            java里使用线程用3种方法：
            1.  继承Thread，重写run方法
            2.  实现Runnable,重写run方法
            3.  使用Callable和Future接口创建线程，并能得到返回值
            @Async可视为第4种方法。基于@Async标注的方法，称之为异步方法,这个注解用于标注某个方法或某个类里面的所有方法都是需要异步处理的。被注解的方法被调用的时候，会在新线程中执行，而调用它的方法会在原来的线程中执行。
        </pre>
    + @Named
        <pre>
            @Named和Spring的@Component功能相同。@Named可以有值，如果没有值生成的Bean名称默认和类名相同。比如
            @Named 
            public class Person 
            或
            @Named(“cc”) 
            public class Person
        </pre>
    + @Validated
        <pre>
            @Valid是对javabean的校验，如果想对使用@RequestParam方式接收参数方式校验使用@Validated
        </pre>
    + @CrossOrigin
        <pre>
            是Cross-Origin ResourceSharing（跨域资源共享）的简写
        </pre>
    + @RestController
        <pre>
            @RestController = @Controller + @ResponseBody。
            是2个注解的合并效果，即指定了该controller是组件，又指定方法返回的是String或json类型数据，不会解决成jsp页面，注定不够灵活，如果一个Controller即有SpringMVC返回视图的方法，又有返回json数据的方法即使用@RestController太死板。
            灵活的作法是：定义controller的时候，直接使用@Controller，如果需要返回json可以直接在方法中添加@ResponseBody
        </pre>
    + @Controller:处理http请求
    + @ResponseBody
        <pre>
            当加上@ResponseBody注解后不会解析成跳转地址 会解析成相应的json格式的对象 集合 字符串或者xml等直接返回给前台 可以通过 ajax 的“success”：fucntion(data){} data直接获取到。
        </pre>
    + @RequestMapping
        <pre>
            处理映射请求的注解。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。有6个属性。

            1、 value， method:
            value：指定请求的实际地址，指定的地址可以是URI Template 模式；
            method：指定请求的method类型， GET、POST、PUT、DELETE等；
            @RequestMapping(value = “/testValid”, method = RequestMethod.POST)  
            2、 consumes，produces：
            consumes： 指定处理请求的提交内容类型（Content-Type），例如@RequestMapping(value = ”/test”, consumes=”application/json”)处理application/json内容类型
            produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
            3、 params、headers：
            params： 指定request中必须包含某些参数值是，才让该方法处理。
            headers：指定request中必须包含某些指定的header值，才能让该方法处理请求
        </pre>
    + @GetMapping和@PostMapping
        <pre>
             @GetMapping(value = “page”)等价于@RequestMapping(value = “page”, method = RequestMethod.GET)

            @PostMapping(value = “page”)等价于@RequestMapping(value = “page”, method = RequestMethod.POST)
        </pre>
    + @Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处:
        <pre>
            1、可以当注释用,方便阅读；

            2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法。
        </pre>
