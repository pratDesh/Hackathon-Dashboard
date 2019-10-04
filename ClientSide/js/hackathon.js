function getHackathons(url) {
    var promise = ajaxGET(url);
    promise.done(function (data){displayHackathonTable(data)});
}

function displayHackathonTable(jsonHackathon) {
    var tableHeaders = ["ID", "Event Name", "MO Office","Date Conducted", "Total Ideas"];
    var container = document.getElementById('hotTable');
    hot = new Handsontable(container, {
        data: jsonHackathon,
        columns: [
            {
                data: 'id', width: 10, readOnly: true,
            },
            {
                data: 'eventName', width: 150, readOnly: true,
            },
            {
                data: 'moOffice', width: 150, readOnly: true,
            },
            {
                data: 'dateConducted', width: 150, readOnly: true,
            },
            {
                data: 'totalIdeas', width: 150, readOnly: true,
            },
        ],
        hiddenColumns: {columns:[0]},
        className: "htCenter",
        rowHeaders: true,
        colHeaders: tableHeaders,
        licenseKey: 'non-commercial-and-evaluation'
    });

    hot.addHook('afterSelection', function (row1, col1, row2, col2) {
        if(col1 === 1) {
            hackathonId = hot.getDataAtRowProp(row1,'id');
            getIdeas(hackathonId);
        }
    });
}
