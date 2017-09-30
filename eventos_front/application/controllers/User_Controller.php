<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class User_Controller extends CI_Controller {

    public function __construct() {
        parent::__construct();
    }

    /*
     * Routes Methods
     */

    public function index() {
        if (!$this->session->userdata('is_logged_in')) {
            $this->load->view('admin/login/index');
        } else {
            redirect('dashboard');
        }
    }

    public function signup() {
        if (!$this->session->userdata('is_logged_in')) {
            $this->load->view('admin/login/signup_form');
        } else {
            redirect('dashboard');
        }
    }

    /*
     * Methods
     */

    public function __encrip_password($password) {
        return md5($password);
    }

    public function auth() {
        $this->load->model('Users_model');
        $user_email = $this->input->post('user_email');
        $user_password = $this->__encrip_password($this->input->post('user_password'));
        $user = $this->Users_model->user_auth($user_email, $user_password);

        if (!isset($user['user']['meta'])) {
            $data = array(
                'default_user' => $user['user'],
                'is_logged_in' => true
            );
            $this->session->set_userdata($data);
            redirect('dashboard');
        } else {
            $data['message_error'] = true;
            $this->load->view('admin/login/index', $data);
        }
    }

    public function create() {
        printr('Chamou essa merda!');
        $this->load->view('admin/login/signup_form');
    }

    public function logout() {
        $this->session->sess_destroy();
        redirect('');
    }

}
