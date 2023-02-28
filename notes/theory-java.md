### Блоки инициализации в Java

Когда вы создаете объект, вам часто приходится устанавливать значение одного или нескольких переменных. В большинстве
случаев это делает конструктор. Другие инструменты, которые могут устанавливать значение переменных - это блоки
инициализации.

### Инициализация глобальных переменных

Глобальные переменные всегда инициализируются, и если это не сделано явно, то они инициализируются нулевым значением.

### Неявная инициализация @Autowired через конструктор

Еще одним преимуществом является то, что при использовании Spring версий 4.3+ вы можете полностью отвязать ваш класс от
конкретного DI-фреймворка. Причина в том, что Spring теперь поддерживает неявное внедрение через конструктор для
сценариев использования с одним конструктором. Это означает, что вам больше не нужны DI-аннотации в вашем классе.
Конечно, вы можете достигнуть того же результата с помощью явного конфигурирования DI в настройках Spring для данного
класса; просто сейчас это сделать гораздо проще.

Consider the following service class:

``` 
@Service
public class FooService {

    private final FooRepository repository;

    @Autowired
    public FooService(FooRepository repository) {
        this.repository = repository
    }
}
```

Quite a common use case but if you forget the @Autowired annotation on the constructor, the container will throw an
exception looking for a default constructor, unless you explicitly indicate autowire mode 'constructor' in your bean
definition setup (e.g. in an XML <bean>).

So as of 4.3, you no longer need to specify an explicit injection annotation in such a single-constructor scenario. This
is particularly elegant for classes which otherwise do not carry any container annotations at all, for example when
programmatically registered:

``` 
public class FooService {

    private final FooRepository repository;

    public FooService(FooRepository repository) {
        this.repository = repository
    }

}
```

Similarly, you may have noticed that @Configuration classes historically did not support constructor injection. They do
now as of 4.3, and they obviously allow for omitting @Autowired in a single-constructor scenario as well...

``` 
@Configuration
public class FooConfiguration {

    private final FooRepository repository;

    public FooConfiguration(FooRepository repository) {
        this.repository = repository
    }

    @Bean
    public FooService fooService() {
        return new FooService(this.repository);
    }

}
```

[Source](https://spring.io/blog/2016/03/04/core-container-refinements-in-spring-framework-4-3)