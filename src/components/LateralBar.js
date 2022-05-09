import React from 'react';
import './style.css'
import entradaIcon from '../assets/entrada.png';
import hojeIcon from '../assets/hoje.png';
import { Link } from 'react-router-dom';

function LateralBar(){
    return (
        <div className="lateral-bar">
            <div className="lateral-bar-content">
                <div className="link">
                    <div style={{float: "left"}}>
                        <img style= {{width: "20px"}} src={entradaIcon} alt="Entrada" />
                    </div>
                    <div>
                        <Link style={{marginLeft: "5px"}} to="/entrada">Entrada</Link>
                    </div>
                </div>
                <div  className="link">
                    <div style={{float: "left"}}>
                        <img style={{width: "17px"}}  src={hojeIcon} alt="Hoje" />
                    </div>
                    <div>
                        <Link style={{marginLeft: "5px"}} to="/Hoje">Hoje</Link>
                    </div>
                </div>
            </div>
           
        </div>
    )
}
export default LateralBar;
