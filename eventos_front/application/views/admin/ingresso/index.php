<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Ingresso</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a href="<?php echo base_url();?>departments/create" class="btn btn-info">
                <i class="fa fa-plus" aria-hidden="true"></i>
                Novo Ingresso
            </a>
        </div>
        <hr />
     </div>

    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="departments-table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Valor</th>                                
                                <th>Ações</th>
                            </tr>
                        </thead>

                        <tbody id="departments-body">
                        </tbody>

                    </table>
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
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
            url: "departments/read",
            success: function (departments) {
                table = $('#departments-table').dataTable({
                    responsive: true,
                    "data": departments,
                    "columns": [                        
                        {data: "image"},
                        {data: "name"},
                        {
                            data: null,
                            className: "center",
                            defaultContent: '<a href="" class="department_edit">Editar</a> / <a href="" class="department_remove">Remover</a>',
                            orderable: false
                        }

                    ]
                });
            },
            error: function () {

            }
        });
        // Edit department
        $('#departments-table tbody').on('click', 'a.department_edit', function (e) {
            e.preventDefault();
            var data = table.api().row($(this).parents('tr')).data();
        });
        // Delete a department
        $('#departments-table tbody').on('click', 'a.department_remove', function (e) {
            e.preventDefault();
            var data = table.api().row($(this).parents('tr')).data();
        });
    });
</script>
