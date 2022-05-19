theme: /outbound
    
    state: smartText
        event!: smartEvent
        image: /src/text-campaign.png
        a: Приглашаем вас на вебинар "Как сделать рассылки из бота". Дата: 24 мая, время: 12:00. Цена билета: 1200 руб.
        buttons: 
            "Купить билет" -> ./BuyTicket
            "Узнать подробнее" -> ./eventInfo
            "Задать вопрос спикеру" -> ./AskQ
        script:
            $analytics.setTextCampaignResult("Ничего не сделали");
            
        state: BuyTicket
            a: Для покупки билета введите вашу почту:
            go: Email
        
            state: Email
                q: * $Email *
                a: На вашу почту {{ $request.query }} будет отправлен билет на мероприятие.
                a: Если у вас есть вопросы, вы можете задать их здесь.
                script:
                    $analytics.setTextCampaignResult("Купили билет");
            
        state: eventInfo
            a: Мы расскажем вам, как создавать простые и интерактивные рассылки в VK, Telegram и WhatsApp.
            buttons: 
                "Купить билет" -> ./BuyTicket
            script:
                $analytics.setTextCampaignResult("Нажали Подробнее");
                
        state: AskQ
            a: Напишите ваш вопрос:
            script:
                $analytics.setTextCampaignResult("Задали вопрос");
            go: getQ
            
            state: getQ
                q: *
                a: Спасибо за ваш вопрос, мы постараемся его задать!
                image: /src/text-campaign.png
                
    state: simpleText
        event!: simpleEvent
        image: https://news.itmo.ru/images/news/big/p9589.jpg
        a: Новый вебинар от компании Just AI - "Как сделать рассылки из бота"
        inlineButtons:
            {text:"Перейти на сайте", url:"https://just-ai.com"}
        script:
            $analytics.setTextCampaignResult("Получили рассылку");
        