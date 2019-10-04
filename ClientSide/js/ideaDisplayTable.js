function displayIdeasTable(jsonData) {
    var ideaList = jsonData.ideaDTOs;
    headingName(jsonData.eventName);
    showBackButton(true);
    showAddButton(true);
    var ideaTableHeaders = ["Idea Summary", "Idea Details", "Category", "Team Members", "Likes", "Action", "Edit"];
    var container = document.getElementById('hotTable');
    $("#hotTable").empty();
    hot = new Handsontable(container, {
        data: ideaList,
        columns: [
            {
                data: 'summary',
                width: 200,
                readOnly: true,
            },
            {   data: 'details',
                width: 250,
                readOnly: true,
            },
            {
                data: 'category',
                width: 100,
                readOnly: true,
            },
            {
                data: 'teamMembers',
                width: 150,
                readOnly: true,
            },
            {
                data: 'likes',
                width: 70,
                readOnly: true,
            },
            {
                data:'id',
                width: 70,
                renderer: likeButtonRenderer
            },
            {
                data: 'id',
                width: 70,
                renderer: editButtonRenderer
            }
        ],
        className: "htCenter",
        rowHeaders: true,
        colHeaders: ideaTableHeaders,
        licenseKey: 'non-commercial-and-evaluation'
    });

    hot.addHook('afterSelection',function(row1, col1, row2, col2){
        setIdeaValues(row1);
        if(col1 === 6) {
            showAddSaveButton(false);
            showEditSaveButton(true);
            $('#addIdeaFormModal').modal('toggle');
        }
        if(col1 === 5) {
            ideaLikes(ideaLikes()+1);
            editIdea(false);
        }
    });
}

function setIdeaValues(row) {
    ideaSummary(hot.getDataAtRowProp(row,'summary'));
    ideaDescription(hot.getDataAtRowProp(row,'details'));
    ideaCategory(hot.getDataAtRowProp(row,'category'));
    ideaTeamMembers(hot.getDataAtRowProp(row,'teamMembers'));
    ideaLikes(hot.getDataAtRowProp(row,'likes'));
    ideaId(hot.getDataAtRowProp(row,'id'));
}

function likeButtonRenderer(instance, td, row, col, prop, value, cellProperties) {
    td.innerHTML = '<button title="Like this Idea" type="button" class="btn btn-outline-primary " style="margin-left: 8px" ><i class="fas fa-thumbs-up"></i></button>'
};

function editButtonRenderer(instance, td, row, col, prop, value, cellProperties) {
    td.innerHTML = '<button title="Edit this Idea" type="button" class="btn btn-outline-primary " style="margin-left: 8px" ><i class="fas fa-pen"></i></button>'
};