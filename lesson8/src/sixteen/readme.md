# Задача 16

Вы продолжаете разработку приложения для ветеринарной клиники. Уже спроектирована схема данных и есть первичное наполнение, следующим шагом вы решаете разработать DAO-классы для работы с базой данных клиники. Для этого вы добавляете в приложение классы сущностей клиента (Client) и питомца (Pet) и определяетесь с составом необходимых методов DAO-классов:

Client createClient(Client client);
Создание нового клиента. Если в базе данных уже существует клиент с переданным номером телефона, метод выбрасывает исключение.

Client findClient(Integer id);
Поиск клиента по идентификатору.

Client updateClient(Client client);
Изменение информации о клиенте. Фамилия, имя и номер телефона клиента в базе данных заменяется на значения, указанные в полях параметра client. Идентификатор клиента, данные которого должны быть изменены, также задается полем объекта client.

void deleteClient(Integer id);
Удаление клиента из базы.

Pet createPet(String name, Integer age, List<Client> clients);
Создание нового питомца.  В базе создаётся запись о питомце с указанными данными и заданным списком клиентов.

Pet findPet(Integer medicalCardNumber);
Поиск питомца по номеру мед карты.

Pet updatePet(Pet pet);
Изменение информации о питомце. Имя и возраст питомца в базе данных заменяется на значения, указанные в полях параметра pet. Номер медицинской карты питомца, данные которого должны быть изменены, также задается полем объекта pet.

void deletePet(Integer medicalCardNumber);
Удаление питомца из базы.

List<String> findClientPhoneNumbersBy(Pet pet);
Поиск номеров телефонов клиентов-хозяев указанного питомца.

List<Pet> getAllPetsOf(Client client);
Получение всех питомцев клиента.

Не забудьте протестировать собственное решение (любым способом, можно просто вызывать требуемые методы из main-метода с произвольными параметрами.
Реализуйте программу с указанными операциями.
