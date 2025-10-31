import React from 'react';
import OrderService from '../services/OrderService';

class OrderComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            orders:[]
        }
    }

    componentDidMount(){
        OrderService.getOrders()
        .then((response) => {
            console.log(response.data);
        //    this.setState({ orders: response.data})
            this.setState({ orders: response.data });
        })
        .catch(error => console.error(error));
    }

    render (){
        const { orders } = this.state;
        return (
            
      <div>

<h1 className = "text-center"> Order List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> Order Id</td>
                            <td> Name</td>
                            <td> Quantity</td>
                            <td> Price</td>
                        </tr>

                    </thead>
                              <tbody>
                        {
                            this.state.orders.map(
                                order => 
                                <tr key = {order.orderId}>
                                     <td> {order.orderId}</td>   
                                     <td> {order.name}</td>   
                                     <td> {order.qty}</td>   
                                     <td> {order.price}</td>   
                                </tr>
                            )
                        }

                    </tbody>
                </table>
      </div>

        )
    }
}

export default OrderComponent