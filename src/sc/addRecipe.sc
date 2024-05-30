theme: /

    state: ДобавлениеЭлемента
        q!: (~добавить | добав* | установ* | запи* | созда* | заки*)
            [~рецепт]
            $AnyText::anyText

        random:
            a: Добавлено!
            a: Записано!

        script:
            addNote($parseTree._anyText, $context);
