var table = $('#example').DataTable();
var data = table.column(5).data();

$(document).ready(function () {
    $('#example').DataTable({
        "columns": [
            null,
            null,
            null,
            null,
            null,
            {"searchable": false}
        ],
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv',
            {
                extend: 'excel',
                title: 'Информация о походах',
            },
            {
                extend: 'pdf',
                title: 'Информация о походах',
                messageTop:
                    "Туристический клуб Майорка",
                messageBottom: "Более подробную информацию о предстоящих походах " +
                    "Вы найдете по ссылке 'Подробнее', либо на сайте туристического клуба. По любым вопросам обращаться к администратору по номеру +375298079485 МТС",
                exportOptions: {
                    format: {
                        body: function (data, row, column, node) {
                            return column === 5 ?
                                'http://localhost:5000/hikes' :
                                data;
                        }
                    }
                }
            },
            {
                extend: 'print',
                title: 'Информация о походах',
                messageTop:
                    "Туристический клуб Майорка",
                messageBottom: "Более подробную информацию о предстоящих походах " +
                    "Вы найдете по ссылке 'Подробнее', либо на сайте туристического клуба. " +
                    "По любым вопросам обращаться к администратору по номеру +375298079485 МТС",
                exportOptions: {
                    format: {
                        body: function (data, row, column, node) {
                            return column === 5 ?
                                '<a href="http://rtss.by/images/reports/2019shipunov.pdf">' + data + '</a>' :
                                data;
                        }
                    }
                }

            }
        ]
    });
    $('.dataTables_length').addClass('bs-select');
    $('.buttons-excel, .buttons-print, .buttons-copy, .buttons-csv, .buttons-pdf').each(function () {
        $(this).removeClass('btn-default').addClass('btn btn-light')
    })
    $('.dataTables_filter').each(function () {
        $(this).removeClass('dataTables_filter').addClass('dataTables_filter input-group-for-hike-search')
    })
    $('.paginate_button').each(function () {
        $(this).removeClass('paginate_button').addClass('paginate_button btn btn-light')
    })
});
