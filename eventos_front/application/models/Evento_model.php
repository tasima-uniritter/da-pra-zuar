<?php

class Evento_model extends CI_Model {

    function __construct() {
        parent::__construct();
        $this->curl->http_header('Content-type', 'application/json');
    }

    /*
     * Routes Methods
     */

    public function create($object) {
         $this->curl->create(BASE_URL_API . '/evento/');
        $evento = array(          
            'nome' => $object['nome_evento'],
            'data' => $object['data_evento']
            );

        $data= json_encode($evento);        
        $this->curl->post($data);
        $result = json_decode($this->curl->execute(), true);
        return $result;
    }

    public function read() {
        $this->curl->create(BASE_URL_API . '/eventos');
        $this->curl->get();
        $result = json_decode($this->curl->execute(), true);
        return $result;
    }

    public function search($name_product) {
        $this->curl->create(BASE_URL_API . '/products/search/');
        $data['obj'] = json_encode(array('name' => $name_product));
        $this->curl->post($data);
        $result = json_decode($this->curl->execute(), true);
        return $result;
    }

}
