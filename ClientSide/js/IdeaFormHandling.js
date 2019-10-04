$(function() {
    $("#addIdeaForm").validate({
        rules: {
            inputIdeaSummary: "required",
            inputIdeaDescription: "required"
        },
        messages: {
            inputIdeaSummary: "Please provide Summary",
            inputIdeaDescription: "Please provide Description"
        },
        submitHandler: function(form) {
            showAddSaveButton() ? saveIdea() : editIdea(true);
        }
    });
});
