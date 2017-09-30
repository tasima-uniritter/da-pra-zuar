<?php

defined('BASEPATH') OR exit('No direct script access allowed');
include('Base_Controller.php');

class Ingresso_Controller extends Base_Controller {

    public function __construct() {
        parent::__construct();        
    }

    /*
     * Routes
     */

    public function index() {
        $this->load_view('admin/ingresso/index');
    }

    public function create() {
        $this->load_view('admin/ingresso/create_ingresso');
    }


    /*
     * Methods
     */

    

}
