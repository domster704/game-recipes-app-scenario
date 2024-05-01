theme: /

    state: ДобавлениеЭлемента
        q!: (~добавить|~установить|запиши|поставь|закинь|~напомнить) 
            [~рецепт]
            $AnyText::anyText

        random:
            a: Добавлено!
            a: Записано!

        script:
            log('addNote: context: ' + JSON.stringify($context))
            addNote($parseTree._anyText, $context);