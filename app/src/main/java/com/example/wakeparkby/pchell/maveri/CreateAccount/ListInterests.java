package com.example.wakeparkby.pchell.maveri.CreateAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;

public class ListInterests {

    HashMap<String, String[]> hashMap;
    public static ArrayList<String> listInterests = new ArrayList<>();

    public static HashMap<String, String[]> getInterests() {
        HashMap<String, String[]> mapInterests = new HashMap<>();
        ArrayList<String[]> current = new ArrayList<>();
        String group[] = {"Музыка", "Фильмы и ТВ Шоу", "Мода и Красота", "Спорт", "Путешествия", "Профессия", "Хобби", "Книги и Культура", "Другое"};
        String music[] = {"Рок'н'ролл", "Рэп", "Поп рок", "Хаус", "Хип Хоп", "Регги", "Электронная", "Техно", "Сальса", "R&B", "Латино", "Джаз", "Классическая", "Танцевальная", "Рок", "Соул", "Drum'n'bass"};
        String films[] = {"Боевик", "Комедия", "Ужасы", "Приключенческий", "Документальный", "Мультик", "Триллер", "Драма", "Вестерн", "Детектив", "Мелодрама", "Исторический", "Музыкальный", "Нуар", "Сказка"};
        String beauty[] = {"Татуировки", "Шопинг", "Мода", "Пирсинг", "Ювелирные изделия", "Загар", "Массаж", "Фотография", "Коллекционирование парфюма", "Дизайн", "Косметика", "Модельный бизнес", "Журналы"};
        String sport[] = {"Футбол", "Плавание", "Тяжёлая атлетика", "Бег", "Баскетбол", "Бокс", "Мотоспорт", "Тeннис", "Волейбол", "Спортивная рыбалка", "Боулинг", "Стрельба", "Сноубординг", "Хоккей", "Гольф"};
        String travels[] = {"Океан", "Путешествия на выходных", "Автомобильные путешествия", "Путешествия за рубеж", "Горы", "Пляжный отдых", "Природа", "Лес", "Кругосветные путешествия", "Мототуризм", "Тропики"};
        String professions[] = {"Студент", "ИП", "Машиностроение", "SMM", "Строительство", "Техник", "Программировние", "Логистика", "Графический дизайн", "Медицина", "Наука", "Архитектура", "Военный", "Психолог"};
        String hobby[] = {"Слушать музыку", "Автомобили", "Просмотр кинофильмов", "Путешествия", "Прогулки по пляжу", "Музыка", "Видео игры", "Пить пиво", "Танцевать", "Чтение книг", "Туризм", "Шоппинг", "Пение"};
        String books[] = {"Биографии", "Детективы", "Фэнтази", "Научная фантастика", "Аниутопии", "Военное дело", "Сказки", "История", "Романы", "Психология", "Саморазвитие", "Финансы", "Ужасы", "Манга", "комиксы"};
        String other[] = {"Знакомства", "Интернет", "Друзья и близкие", "Сон", "Приключения", "Фестивали", "Фотография", "Опера", "Йога", "Танцы", "Изучение языков", "SMM", "Медитация", "Медитация", "Караоке"};
        current.add(music);
        current.add(films);
        current.add(beauty);
        current.add(sport);
        current.add(travels);
        current.add(professions);
        current.add(hobby);
        current.add(books);
        current.add(other);

        for (int i = 0; i < current.size(); i++)
            mapInterests.put(group[i], current.get(i));

        return mapInterests;
    }

    ListInterests() {
        this.hashMap = getInterests();
    }

    public static void setListInterests(ArrayList<String> qwe) {
        for (String z : qwe) {
            listInterests.add(z);
        }
    }

    public static ArrayList<String> getListInterests() {
        return listInterests;
    }

}