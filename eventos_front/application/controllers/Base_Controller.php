<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Base_Controller extends CI_Controller {

    public function __construct() {
        parent::__construct();      
    }
    
    public function load_view($view, $vars = array()) {
        $this->load->view('admin/includes/nav-header', $vars);
        $this->load->view('admin/includes/side-menu');
        $this->load->view($view, $vars);
        $this->load->view('admin/includes/nav-footer');
    }

}
