### Mixed

Рекомендуется создавать представления в директории, соответствующей названию контроллера, в чьем методе они вызываются.

### Controllers

@Controller - тот же @Component, но с дополнительными возможностями.

@Controller наследуется от @Component.

@ComponentScan работает с @Controller так же, как и с @Component.

Обычно контроллеры соответствуют одному URL-адресу и возвращают одно соответствующее представление.

### Mappings

- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping

Маппинги связывают метод контроллера с адресом, по которому можно к этому методу обратиться.

Устаревший вариант: @RequestMapping(method = RequestMethod.GET)

Актуально использовать @RequestMapping("/address") над **классом**. 