var doc = $(document);
doc.ready(function () {
    // Delete a person
    doc.on('click', '.deletePerson', function (e) {
        var target = $(e.target);
        var id = target.data('id');
        jsRoutes.controllers.Person.delete(id).ajax({
            success: function (data) {
                target.closest('li').remove();
            }
        });
    });

    // Create a new person
    $('#createPerson').click(function () {
        var personNameInput = $('#personName');
        var personName = personNameInput.val();
        var personIdInput = $('#personId');
        var personId = personIdInput.val();
        if (personName && personName.length > 0) {
            var data = {
                'id': personId,
                'name': personName
            };
            jsRoutes.controllers.Person.create().ajax({
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function (person) {
//                    $('#peopleList').append('<li>' + person.name + ' <a href="#" data-id="' + person.id + '" class="deletePerson">Delete</a></li>');
                    getAllDust();

                    personNameInput.val('');
                    personIdInput.val('');
                }
            });
        }
    });

    // Load existing data from the server
//    jsRoutes.controllers.Person.getAll().ajax({
//        success: function (data) {
//            console.log(data);
//            var peopleList = $('#peopleList');
//            $(data).each(function (index, person) {
//                peopleList.append('<li>' + person.name + ' <a href="#" data-id="' + person.id + '" class="deletePerson">Delete</a></li>');
//            });
//        }
//    });
    getAllDust();
});
function getAllDust(){
    jsRoutes.controllers.Person.getAllDust().ajax({
        success: function (data) {
            console.log('data = ' + JSON.stringify(data));
            dust.render('example', data, function (err, out) {
                console.log(out)
                $('#dust_pan').html(out);
            });
        }
    });
}

