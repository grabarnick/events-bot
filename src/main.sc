require: requirements.sc
  
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Это бот мероприятий Just AI. Здесь вы можете узнать про наши новые события, купить билеты, получить разные скидки и бонусы!
        script:
            $analytics.setSessionData("Канал", "Виджет")

    state: Bye
        intent!: /пока
        a: Пока пока
        script:
            $analytics.setSessionData("Источник", "Google")
        
    state: Ask
        intent!: /вопрос
        a: Напишите ваш вопрос:
        go: Question
        
        state: Question
            q: *
            a: Спасибо за ваш вопрос, мы передали его спикеру!
        
            
    state: TicketReturn
        intent!: /возврат
        a: Возврат билетов осуществляется не позднее, чем за 5 дней до начала мероприятия.Деньги вернуться вам в течение 10 дней.
        a: Для возврата билета введите вашу почту:
        go: ReturnEmail
        
        state: ReturnEmail
            q: * $Email *
            a: Возврат оформлен, ожидайте возврата средств.
            a: Если у вас есть другие вопросы, вы можете задать их здесь.
    
    state: NewEvent
        event!: newEvent
        a: 24 мая состоится вебинар, посвященный рассыкам в ботах от Just AI.
        buttons:
            "Узнать подробнее"
        
        state: moreInfo
            q: Узнать подробнее
            a: Подробная информация
        

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
