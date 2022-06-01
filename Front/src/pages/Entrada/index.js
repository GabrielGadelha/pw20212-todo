import React, {useState,useEffect} from 'react';
import { Link } from 'react-router-dom';
import LateralBar from '../../components/LateralBar';
import Topo from '../../components/Topo'
import List from '../../components/List';
import Form from '../../components/Form';
import supabase from '../../services/api';
import './style.css'

function Entrada () {
    const [itemsList, setItemsList] = useState([]);

    useEffect(
        ()=>{
            async function loadData(){
                try {
                    const { data, error } = await supabase
                    .from('tb_todos')
                    .select(`todo`)

                    if (error) {
                        throw error
                    }
                    if (data) {
                        let tasks = data.map(function(obj) {
                            return Object.keys(obj).map(function(key) {
                                return obj[key];
                            });
                        });
                        setItemsList(tasks);
                    }
                } catch (error) {
                    alert("Erro ao carregar dados")
                }
            }
            loadData();
        },[]);

    function handleAddItemToList(newItem) {   // <------------
        setItemsList([...itemsList, newItem])
      }

    const handleRemoveItemToList = (item) =>{
       setItemsList(
           [...itemsList.filter(
               (task) => {
                    return task !== item
                    }
                )
            ]
        );
        async function remove(){
            try {
                const { error } = await supabase
                .from('tb_todos')
                .delete()
                .match({ todo: item })
                if (error) {
                    throw error
                }
            } catch (error) {
                alert("Erro ao carregar dados")
            }
        }
        remove();
    }
    return (
        <div>
           <Topo />
           <LateralBar />
           <div className="content">
                <h1>Entrada</h1>
                <List itemsList={itemsList} onRmItem={handleRemoveItemToList} />
                <Form onAddItem={handleAddItemToList} />

                <Link to="/">sair</Link>
            </div>
        </div>
    );
}
export default Entrada;

