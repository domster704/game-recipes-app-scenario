theme: /

    state: ДобавлениеЭлемента
        q!: (~добавить | добав* | установ* | запи* | созда* | заки*)
            [~рецепт]
            $AnyText::anyText

        random:
            a: Добавлено!
            a: Записано!

        script:
            addRecipe($parseTree._anyText, $context);
