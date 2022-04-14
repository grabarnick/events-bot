theme: /outbound
    
    state: newEvent
        event!: newEvent
        # intent!: /список
        a: Приглашаем вас на вебинар "Как сделать рассылки из бота".
        a: Дата: 24 мая, время: 12:00
        a: Цена билета: 1200 руб.
        buttons: 
            "Купить билет" -> /BuyTicket
            "Узнать подробнее" -> ./eventInfo
        script:
            $analytics.setTextCampaignResult("Получили рассылку");
            
        state: eventInfo
            a: Мы расскажем вам, как создавать простые и интерактивные рассылки в VK, Telegram и WhatsApp.
            buttons: 
                "Купить билет" -> /BuyTicket
            script:
                $analytics.setTextCampaignResult("Нажали Подробнее");
                
    state: simpleText
        event!: simpleEvent
        # intent!: /список
        a: 
            Новый вебинар от компании Just AI - "Как сделать рассылки из бота".
            Дата: 24 мая, время: 12:00
        image: https://just-ai.com/ru/wp-content/themes/justai_ru/img/func_2x2.png
        inlineButtons:
            {text:"Перейти на сайте", url:"https://just-ai.com"}
        