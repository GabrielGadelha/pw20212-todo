import React, { useState } from 'react';
import supabase from '../services/api';
import './style.css'

function Form(props) {

    const [task, setTask] = useState('');
  
    async function handleAddItemToList(e){
        e.preventDefault();
        if(task) {
          props.onAddItem(task) 
          
          setTask("");
        }
      
        const insert = {
            todo: task,
        }
    
        try{
          const { error } = await supabase
          .from('tb_todos')
          .insert([insert]);
          if (error) {
            throw error
          }
        }catch (error) {
          alert(error.message)
        }
        
    }
    return (
        <div>
             <form onSubmit={handleAddItemToList}>
                    <input
                     placeholder="To do"
                    value={task}
                        onChange={e=>setTask(e.target.value)}/>
                   
                    <button typy="submit" className="button"> Adicionar tarefa </button>
                   

                </form>
        </div>
    );
}
export default Form;
 
  