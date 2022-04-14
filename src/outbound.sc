theme: /outbound
    
    state: newEvent
        event: newEvent
        # intent!: /список
        a: Приглашаем вас на вебинар "Как сделать рассылки из бота".
        a: Дата: 24 мая, время: 12:00
        a: Цена билета: 1200 руб.
        buttons: 
            "Купить билет" -> /BuyTicket
            "Узнать подробнее" -> ./eventInfo
            
        state: eventInfo
            a: Мы расскажем вам, как создавать простые и интерактивные рассылки в VK, Telegram и WhatsApp.
            buttons: 
                "Купить билет" -> /BuyTicket