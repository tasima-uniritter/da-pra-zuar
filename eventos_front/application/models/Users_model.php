<?php

class Users_model extends CI_Model {

    function __construct() {
        parent::__construct();
        $this->curl->http_header('Content-type', 'application/x-www-form-urlencoded');
    }

    public function user_auth($email, $password) {
        $this->curl->create(BASE_URL_API.'/user/oauth/');
        $data['obj'] = json_encode(array('email' => $email, 'password' => $password));
        $this->curl->post($data);
        $result = json_decode($this->curl->execute(), true);
        return $result;
    }

    public function user_create($object){
        vardump($object);
    }
    
}
