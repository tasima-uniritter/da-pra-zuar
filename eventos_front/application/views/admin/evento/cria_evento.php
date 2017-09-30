
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Cadastrar Evento</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-6">
                        <form role="form" action="save" method="post" id="form">
                            <div class="form-group">
                                <label>Nome do Evento:</label>
                                <input class="form-control" id="nome_evento" name="nome_evento" required="required">                               
                            </div>
							
							<div class="form-group" id='data_field'>
							
                                <label>Data:</label>
								
                                <input type="date" onchange="validateDate()" class="form-control" id="data_evento" name="data_evento" required="required">                               
                            </div>
                           
                            <button type="submit" class="btn btn-success">Salvar</button>
                        </form>
                    </div>
                    <div class="col-md-6">                     
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script>

function validateDate() {
    var userdate = new Date(document.getElementById("data_evento").value).toJSON().slice(0,10);
    var today = new Date().toJSON().slice(0,10);
    if(userdate < today){
      alert("A data do evento deve ser igual ou maior que a de hoje");
	  document.getElementById("data_evento").value = '';
    }else{
		
	}
	
}

$("#form").submit(function(e){
  

    var nome_evento = $('#nome_evento').val();    
    if(nome_evento.length >150){
        alert('O nome permite no máximo 150 caracteres');
        event.preventDefault();        
    }    
    else
        $('#form').submit();
});
</script>

