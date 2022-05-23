theme: /outbound
    
    state: smartText
        event!: smartEvent
        a: xxx
        buttons: 
            "Купить билет" -> ./BuyTicket
            "Узнать подробнее" -> ./eventInfo
            "Задать вопрос спикеру" -> ./AskQ
            
        state: BuyTicket
            q: Купить билет
            a: Для покупки билета введите вашу почту:
            go: Email
        
            state: Email
                q: * $Email *
                a: На вашу почту {{ $request.query }} будет отправлен билет на мероприятие.
                a: Если у вас есть вопросы, вы можете задать их здесь.
                script:
                    $analytics.setTextCampaignResult("Купили билет");
            
        state: eventInfo
            q: Узнать подробнее
            a: Тема вебинара: "Создаем интерактивные рассылки в чат-ботах на платформе JAICP"
            image: https://just-ai.com/ru/wp-content/themes/justai_ru/img/outgoing-mailings-statistics.png
            a: Новый сервис интерактивных исходящих рассылок в мессенджерах и соцсетях. Отправляйте сообщения о промоакциях, услугах и товарах, статусе заказов и доставки через чат-бота и начинайте диалог с клиентом прямо в рассылке!
            buttons: 
                "Купить билет" -> ./BuyTicket
                "Задать вопрос спикеру" -> ./AskQ
            script:
                $analytics.setTextCampaignResult("Нажали Подробнее");
                
        state: AskQ
            q: Задать вопрос спикеру
            a: Напишите ваш вопрос:
            script:
                $analytics.setTextCampaignResult("Задали вопрос");
            go: getQ
            
            state: getQ
                q: *
                a: Спасибо за ваш вопрос, мы постараемся его задать!
                buttons: 
                    "Купить билет" -> ././BuyTicket
                    "Узнать подробнее" -> ././eventInfo
                
                
    state: simpleText
        event!: simpleEvent
        image: https://news.itmo.ru/images/news/big/p9589.jpg
        a: Новый вебинар от компании Just AI - "Как сделать рассылки из бота"
        inlineButtons:
            {text:"Перейти на сайте", url:"https://just-ai.com"}
        