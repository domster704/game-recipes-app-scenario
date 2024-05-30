function addRecipe(recipeTitle, context) {
    addAction({
        type: "add_recipe",
        recipeTitle: recipeTitle
    }, context);
}

function doneNote(id, context){
    addAction({
        type: "done_note",
        id: id
    }, context);
}

function deleteNote(id, context){
    addAction({
        type: "delete_note",
        id: id
    }, context);
}