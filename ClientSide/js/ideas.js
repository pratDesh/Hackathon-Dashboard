function getIdeas(hackathonID) {
    var url =  BASE_URL+"/"+hackathonId+"/ideas"
    var promise = ajaxGET(url);
    promise.done(function (data){displayIdeasTable(data)});
}

function saveIdea() {
    $('#addIdeaFormModal').modal('toggle');
    var url = BASE_URL+"/"+hackathonId+"/ideas"
    var ideaData = setIdeaJsonData()
    var promise = ajaxPOST(url,ideaData);
    promise.done(function (data) {
        ideaAjaxCallSuccess("Idea Added Sucessfully");
    });
}

function editIdea(editClicked) {
    if(editClicked === true) {
        $('#addIdeaFormModal').modal('toggle');
    }
    var url = BASE_URL+"/ideas/"+ideaId()
    var ideaData = setIdeaJsonData();
    var promise = ajaxPUT(url,ideaData);
    promise.done(function (data) {
        if(editClicked === true) {
            ideaAjaxCallSuccess("Idea Updated Succesfully");
        }
        else {
            ideaAjaxCallSuccess("You Liked An Idea");
        }
    });
}

function setIdeaJsonData() {
    return ideaData = {
        "summary": ideaSummary(),
        "details": ideaDescription(),
        "category": ideaCategory(),
        "teamMembers": ideaTeamMembers(),
        "likes": ideaLikes()
    }
}

function ideaAjaxCallSuccess(message) {
    clearFormData();
    alert(message);
    getIdeas(hackathonId);
}