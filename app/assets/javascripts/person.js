var doc = $ ( document ) ;
doc.ready ( function ( ) {
    // Delete a person
    doc.on ( 'click', '.deletePerson', function ( e ) {
        var target = $ ( e.target ) ;
        var id = target.data ( 'id' ) ;
        jsRoutes.controllers.Person.delete ( id ).ajax ( {
            success : function ( data ) {
                target.closest ( 'li' ).remove ( ) ;
            }
        } ) ;
    } ) ;

    // Create a new person
    $ ( '#createPerson' ).click ( function ( ) {
        var personNameInput = $ ( '#personName' ) ;
        var personName = personNameInput.val ( ) ;
        var personIdInput = $ ( '#personId' ) ;
        var personId = personIdInput.val ( ) ;
        if ( personName && personName.length > 0 ) {
            var data = {
                'id' : personId,
                'name' : personName
            } ;
            jsRoutes.controllers.Person.create ( ).ajax ( {
                data : JSON.stringify ( data ),
                contentType : 'application/json',
                success : function ( person ) {
                    $ ( '#peopleList' ).append ( '<li>' + person.name + ' <a href="#" data-id="' + person.id + '" class="deletePerson">Delete</a></li>' ) ;
                    personNameInput.val ( '' ) ;
                    personIdInput.val ( '' ) ;
                }
            } ) ;
        }
    } ) ;

    // Load existing data from the server
    jsRoutes.controllers.Person.getAll ( ).ajax ( {
        success : function ( data ) {
            var peopleList = $ ( '#peopleList' ) ;
            $ ( data ).each ( function ( index, person ) {
                peopleList.append ( '<li>' + person.name + ' <a href="#" data-id="' + person.id + '" class="deletePerson">Delete</a></li>' ) ;
            } ) ;
        }
    } ) ;
} ) ;