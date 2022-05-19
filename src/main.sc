require: requirements.sc
  
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Это бот мероприятий Just AI. Здесь вы можете узнать про наши новые события, купить билеты, получить разные скидки и бонусы!

    # state: EventsList
    #     intent!: /список
    #     script:
    #         var eventsList = getEventsList();
    #         for (var i = 0; i < eventsList.length; i++) {
    #         }
            
    state: Bye
        intent!: /пока
        a: Пока пока
        
    # state: BuyTicket
    #     a: Для покупки билета введите вашу почту:
    #     go: Email
        
    #     state: Email
    #         q: * $Email *
    #         a: На вашу почту {{ $request.query }} будет отправлен билет на мероприятие.
            
    #         a: Если у вас есть вопросы, вы можете задать их здесь.

    state: Ask
        intent!: /вопрос
        a: Напишите ваш вопрос:
        go: Question
        
        state: Question
            q: *
            image: /src/text-campaign.png
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
    
    state: MyTickets
        

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}