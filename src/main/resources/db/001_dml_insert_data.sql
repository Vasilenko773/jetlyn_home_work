insert into animals (id, name, type, is_predator)
values ('07581fda-e9ed-4d00-bb49-6831ebd11111', 'Обезьяна', 'Млекопитающее', false);
insert into animals (id, name, type, is_predator)
values ('07581fda-e9ed-4d00-bb49-6831ebd12222', 'Заяц', 'Млекопитающее', false);
insert into animals (id, name, type, is_predator)
values ('07581fda-e9ed-4d00-bb49-6831ebd13333', 'Орел', 'Птица', true);
insert into animals (id, name, type, is_predator)
values ('07581fda-e9ed-4d00-bb49-6831ebd14444', 'Тигр', 'Млекопитающее', true);
insert into animals (id, name, type, is_predator)
values ('07581fda-e9ed-4d00-bb49-6831ebd15555', 'Лошадь', 'Млекопитающее', false);

insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd21111', 'Морковь', 10012, 'шт', 'Овощ');
insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd22222', 'Мясо', 500, 'кг', 'Мясо');
insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd23333', 'Капуста', 26143, 'кг', 'Овощ');
insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd24444', 'Банан', 780, 'шт', 'Фрукт');
insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd25555', 'Яблоко', 0, 'шт', 'Фрукт');
insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd26666', 'Зерно', 291400, 'кг', 'Зерновые');
insert into products (id, name, count, unit, type)
values ('07581fda-e9ed-4d00-bb49-6831ebd27777', 'Вода', 980514, 'л', 'Жидкость');

-- Вода
insert into consumption_norm (id, animal_id, product_id, size)
values ('07581fda-e9ed-4d00-bb49-6831ebd01111', '07581fda-e9ed-4d00-bb49-6831ebd11111',
        '07581fda-e9ed-4d00-bb49-6831ebd27777', 2.8);
insert into consumption_norm (id, animal_id, product_id, size)
values ('07581fda-e9ed-4d00-bb49-6831ebd02111', '07581fda-e9ed-4d00-bb49-6831ebd12222',
        '07581fda-e9ed-4d00-bb49-6831ebd27777', 1);
insert into consumption_norm (id, animal_id, product_id, size)
values ('07581fda-e9ed-4d00-bb49-6831ebd03111', '07581fda-e9ed-4d00-bb49-6831ebd13333',
        '07581fda-e9ed-4d00-bb49-6831ebd27777', 0.5);
insert into consumption_norm (id, animal_id, product_id, size)
values ('07581fda-e9ed-4d00-bb49-6831ebd04111', '07581fda-e9ed-4d00-bb49-6831ebd14444',
        '07581fda-e9ed-4d00-bb49-6831ebd27777', 5.3);
insert into consumption_norm (id, animal_id, product_id, size)
values ('07581fda-e9ed-4d00-bb49-6831ebd05111', '07581fda-e9ed-4d00-bb49-6831ebd15555',
        '07581fda-e9ed-4d00-bb49-6831ebd27777', 9);

-- Обезбяна
insert into consumption_norm (id, animal_id, product_id, size)
values ('17581fda-e9ed-4d00-bb49-6831ebd01111','07581fda-e9ed-4d00-bb49-6831ebd11111',
        '07581fda-e9ed-4d00-bb49-6831ebd24444', 12);
insert into consumption_norm (id, animal_id, product_id, size)
values ('17581fda-e9ed-4d00-bb49-6831ebd02111','07581fda-e9ed-4d00-bb49-6831ebd11111',
        '07581fda-e9ed-4d00-bb49-6831ebd25555', 5);

-- Заяц
insert into consumption_norm (id, animal_id, product_id, size)
values ('27581fda-e9ed-4d00-bb49-6831ebd01111','07581fda-e9ed-4d00-bb49-6831ebd12222',
        '07581fda-e9ed-4d00-bb49-6831ebd21111', 3);
insert into consumption_norm (id, animal_id, product_id, size)
values ('27581fda-e9ed-4d00-bb49-6831ebd02111','07581fda-e9ed-4d00-bb49-6831ebd12222',
        '07581fda-e9ed-4d00-bb49-6831ebd23333', 1);

-- Орел
insert into consumption_norm (id, animal_id, product_id, size)
values ('37581fda-e9ed-4d00-bb49-6831ebd01111','07581fda-e9ed-4d00-bb49-6831ebd13333',
        '07581fda-e9ed-4d00-bb49-6831ebd22222', 0.5);
insert into consumption_norm (id, animal_id, product_id, size)
values ('37581fda-e9ed-4d00-bb49-6831ebd02111','07581fda-e9ed-4d00-bb49-6831ebd13333',
        '07581fda-e9ed-4d00-bb49-6831ebd26666', 3);
insert into consumption_norm (id, animal_id, product_id, size)
values ('37581fda-e9ed-4d00-bb49-6831ebd03111','07581fda-e9ed-4d00-bb49-6831ebd13333',
        '07581fda-e9ed-4d00-bb49-6831ebd25555', 3);

-- Тигр
insert into consumption_norm (id, animal_id, product_id, size)
values ('47581fda-e9ed-4d00-bb49-6831ebd01111','07581fda-e9ed-4d00-bb49-6831ebd14444',
        '07581fda-e9ed-4d00-bb49-6831ebd22222', 4.5);

-- Лошадь
insert into consumption_norm (id, animal_id, product_id, size)
values ('57581fda-e9ed-4d00-bb49-6831ebd01111','07581fda-e9ed-4d00-bb49-6831ebd15555',
        '07581fda-e9ed-4d00-bb49-6831ebd26666', 5.5);
insert into consumption_norm (id, animal_id, product_id, size)
values ('57581fda-e9ed-4d00-bb49-6831ebd02111','07581fda-e9ed-4d00-bb49-6831ebd15555',
        '07581fda-e9ed-4d00-bb49-6831ebd25555', 20);
insert into consumption_norm (id, animal_id, product_id, size)
values ('57581fda-e9ed-4d00-bb49-6831ebd03111','07581fda-e9ed-4d00-bb49-6831ebd15555',
        '07581fda-e9ed-4d00-bb49-6831ebd21111', 40);


