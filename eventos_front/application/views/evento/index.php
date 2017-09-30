<div id="container">


    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Eventos</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="products-table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Data</th>                            
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody id="products-body">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {
        var table = null;
        $.getJSON({
            type: "POST",
            data: "",
            url: "index.php/evento/read",
            success: function (eventos) {
                console.log(eventos)
                table = $('#products-table').dataTable({
                    responsive: true,
                    "data": eventos,
                    "columns": [
                        {data: "nome"},
                        {data: "data"},                      
                        {
                            data: null,
                            className: "center",
                            defaultContent: '<a href="" class="product_edit">Editar</a> / <a href="" class="product_remove">Remover</a>',
                            orderable: false
                        }

                    ]
                });

            },
            error: function (a) {
                console.log(a);
            }
        });
        // Edit department
        $('#products-table tbody').on('click', 'a.product_edit', function (e) {
            e.preventDefault();
            var data = table.api().row($(this).parents('tr')).data();
        });
        // Delete a department
        $('#products-table tbody').on('click', 'a.product_remove', function (e) {
            e.preventDefault();
            var data = table.api().row($(this).parents('tr')).data();
        });

    });
</script>
