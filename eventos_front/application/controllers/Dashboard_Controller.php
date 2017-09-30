<?php

defined('BASEPATH') OR exit('No direct script access allowed');
include('Base_Controller.php');
class Dashboard_Controller extends Base_controller {

    public function index() {
        $this->load_view('admin/dashboard/index');
    }


}
