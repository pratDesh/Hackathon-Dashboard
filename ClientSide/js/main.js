var viewData = function()  {
    headingName = ko.observable("Hackathons");
    showBackButton = ko.observable(false);
    showAddButton = ko.observable(false);
    showAddSaveButton = ko.observable(true);
    showEditSaveButton = ko.observable(false);
    ideaSummary = ko.observable("");
    ideaDescription = ko.observable("");
    ideaCategory = ko.observable("");
    ideaTeamMembers = ko.observable("");
    ideaLikes = ko.observable(0);
    ideaId = ko.observable(0);
    hackathonId = ko.observable(0);
    BASE_URL = "http://localhost:8080/hackathons";
}

$(document).ready(function(){
    ko.applyBindings(viewData);

    getHackathons(BASE_URL);

    $("#backButton").click(function () {
        $("#hotTable").empty();
        showBackButton(false);
        showAddButton(false);
        headingName("Mediaocean Hackathon")
        getHackathons(BASE_URL);
    });
});