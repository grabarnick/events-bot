theme: /outbound
    
    state: smartText
        event!: smartText
        a: Приглашаем вас на вебинар "Как сделать рассылки из бота".
        a: Дата: 24 мая, время: 12:00
        a: Цена билета: 1200 руб.
        buttons: 
            "Купить билет" -> ./BuyTicket
            "Узнать подробнее" -> ./eventInfo
        script:
            $analytics.setTextCampaignResult("Получили рассылку");
            
        state: BuyTicket
            a: Для покупки билета введите вашу почту:
            go: Email
        
            state: Email
                q: * $Email *
                a: На вашу почту {{ $request.query }} будет отправлен билет на мероприятие.
                
                a: Если у вас есть вопросы, вы можете задать их здесь.
            
        state: eventInfo
            a: Мы расскажем вам, как создавать простые и интерактивные рассылки в VK, Telegram и WhatsApp.
            buttons: 
                "Купить билет" -> ./BuyTicket
            script:
                $analytics.setTextCampaignResult("Нажали Подробнее");
                
    state: simpleText
        event!: simpleEvent
        image: https://news.itmo.ru/images/news/big/p9589.jpg
        a: Новый вебинар от компании Just AI - "Как сделать рассылки из бота"
        inlineButtons:
            {text:"Перейти на сайте", url:"https://just-ai.com"}
        script:
            $analytics.setTextCampaignResult("Получили рассылку");
        