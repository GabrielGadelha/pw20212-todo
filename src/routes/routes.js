import React from "react";
import { Route, Routes, BrowserRouter } from "react-router-dom";

import Login from "../pages/Login";
import Entrada from "../pages/Entrada";

function Rotas() {
   return(
       <BrowserRouter>
            <Routes>
                <Route element = { <Login /> }  path="/" exact />
                <Route element = { <Entrada />}  path="/entrada" />
            </Routes>           
       </BrowserRouter>
   )
}

export default Rotas;