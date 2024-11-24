### [Бот в телеграме](t.me/AstonWorkTrackerBot)

### Как создать новую команду:
1. Зарегистрировать команду в UpdateDispatcher в методе findController <br>
```case "/mycommand" -> defaultCommandsController.myCommand(message, bot);```
2. Добавить соответствующий метод в один из контроллеров (в зависимости от ролей в доске):
* **DefaultCommandController** - Команды, которые не имеют требований к ролям
* **WorkerCommandController** - Команды, которые доступны с ролью работника
* **LeaderCommandController** - Команды, которые доступны с ролью лидера
* **OwnerCommandController** - т.п.

3. Реализовать метод в controller/impl в классе *impl