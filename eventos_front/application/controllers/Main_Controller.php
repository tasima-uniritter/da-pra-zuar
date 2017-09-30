<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Main_Controller extends CI_Controller {

    public function __construct() {
        parent::__construct();
        $this->load->model('Evento_model');
        
    }

    /*
     * Routes Methods
     */

    public function index() {
        $this->load->view('header');        
        $this->load->view('evento/index');
    }

    
    /*
     * Methods
     */

    public function get_eventos() {
        $eventos = $this->Evento_model->read();
        echo json_encode($eventos);
    }

    

}
