import React from 'react';

const List = (props) => {

    const {itemsList} = props;
    return(
        <div style={{marginBottom: "10px"}}>
            {itemsList.map(item => (
            <div>
                 <input type="radio" id={item} value={item} onClick={()=>props.onRmItem(item)}/>
                 <label style={{marginLeft: "5px" }}>{item}</label>
            </div>
           ))
            }           
        </div>
    )
}

export default List;