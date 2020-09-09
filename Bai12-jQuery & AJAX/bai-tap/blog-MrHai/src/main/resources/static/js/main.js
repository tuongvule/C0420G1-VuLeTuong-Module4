let numberOfPage = 6;
$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });
    $("#btn-more").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();

        more_list_blog();

    });

});

function more_list_blog() {

    $("#btn-more").prop("disabled", true);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/more",
        data: {numberOfPage: numberOfPage},
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            let blogs = data.content;
            let json = "<table>";
            for (let i = 0; i < blogs.length; i++) {
                json += "<tr>" +
                    "<td>" + blogs[i].nameBlog + "</td>" +
                    "<td>" + blogs[i].quickView + "</td>" +
                    "<td>" + blogs[i].category.nameCategory + "</td>" +
                    "<td>" + blogs[i].nameBlog + "</td>" +
                    "<td>" + blogs[i].id + "</td>" +
                    "<td><a href='/view-blog/" + blogs[i].id + "'"+">View</a></td>" +
                    "<td><a href='/edit-blog/" + blogs[i].id +"'"+">Update</a></td>" +
                    "<td><a href='/delete-blog/" + blogs[i].id +"'"+ ">Delete</a></td>" +
                    "</tr>"
            }
            json += "</table>";
            document.getElementById("table_blog").innerHTML = json;
            $("#btn-more").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-more").prop("disabled", false);

        }

    });
    numberOfPage += 3;
}

function fire_ajax_submit() {

    var search = {}
    search["nameBlog"] = $("#nameBlog").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            let blogs = data.result;
            console.log("hello")
            let json = "<table>";
            for (let i = 0; i < blogs.length; i++) {
                json += "<tr>" +
                    "<td>" + blogs[i].nameBlog + "</td>" +
                    "<td>" + blogs[i].quickView + "</td>" +
                    "<td>" + blogs[i].category.nameCategory + "</td>" +
                    "<td>" + blogs[i].nameBlog + "</td>" +
                    "<td>" + blogs[i].id + "</td>" +
                    "<td><a href='/view-blog/" + blogs[i].id + "'"+">View</a></td>" +
                    "<td><a href='/edit-blog/" + blogs[i].id +"'"+">Update</a></td>" +
                    "<td><a href='/delete-blog/" + blogs[i].id +"'"+ ">Delete</a></td>" +
                    "</tr>"
            }
            json += "</table>";
            document.getElementById("table_blog").innerHTML = json;
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}