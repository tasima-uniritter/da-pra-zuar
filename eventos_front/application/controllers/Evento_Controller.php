<?php

defined('BASEPATH') OR exit('No direct script access allowed');
include('Base_Controller.php');

class Evento_Controller extends Base_Controller {

    public function __construct() {
        parent::__construct();
        $this->load->model('Evento_model');
        
    }

    /*
     * Routes Methods
     */

    public function index() {
        $this->load_view('admin/evento/index');
    }

    public function create() {       
        $this->load_view('admin/evento/cria_evento');
    }

    /*
     * Methods
     */

    public function get_eventos() {
        $eventos = $this->Evento_model->read();
        echo json_encode($eventos);
    }

    public function save() {
        $data = $this->input->post();
        $evento = $this->Evento_model->create($data);
        
        if ($evento != "OK") {
            $data['message_error'] = true;
            $this->load->view('admin/evento/cria_evento', $data);
        } else {
            redirect('evento');
        }
    }

    public function search_products() {
        $search_field = $this->input->post('name_product');
        $products = $this->Products_model->search($search_field);
        echo json_encode($products['products']);
    }

    public function fetch_departments() {
        $this->load->model('Departments_model');
        $departments = $this->Departments_model->read($this->id_establishment);
        echo json_encode($departments['departments']);
    }

}
