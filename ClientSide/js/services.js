
function ajaxGET(url) {
    return ajaxCall('GET',url,"");
}

function ajaxPOST(url, payloadData) {
    return ajaxCall('POST',url,payloadData);
}

function ajaxPUT(url, payloadData) {
    return ajaxCall('PUT',url,payloadData);
}

function ajaxCall(method, url, payloadData) {
    return  $.ajax({
        url: url,
        type:method,
        contentType:'application/json; charset=utf-8',
        data:JSON.stringify(payloadData),
    });
}

function clearFormData() {
    ideaSummary("");
    ideaDescription("");
    ideaCategory("");
    ideaTeamMembers("");
    ideaLikes("");
    ideaId("");
}

function errorHandler() {
    alert("System ran into a problem");
    getIdeas();
}