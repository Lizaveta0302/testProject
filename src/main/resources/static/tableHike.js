$(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
    $('.dataTables_length').addClass('bs-select');
    $('.buttons-excel, .buttons-print, .buttons-copy, .buttons-csv, .buttons-pdf').each(function() {
        $(this).removeClass('btn-default').addClass('btn btn-light')
    })
    $('.dataTables_filter').each(function() {
        $(this).removeClass('dataTables_filter').addClass('dataTables_filter input-group-for-hike-search')
    })
    $('.paginate_button').each(function() {
        $(this).removeClass('paginate_button').addClass('paginate_button btn btn-light')
    })

} );