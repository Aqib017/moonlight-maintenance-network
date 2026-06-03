import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    Tooltip,
    ResponsiveContainer,
    CartesianGrid
} from "recharts";

function FinanceChart({ collection, expense }) {

    const data = [
        {
            name: "Collection",
            amount: collection
        },
        {
            name: "Expense",
            amount: expense
        }
    ];

    return (

        <div
            style={{
                width: "100%",
                height: 350
            }}
        >

            <ResponsiveContainer>

                <BarChart
                    data={data}
                >

                    <CartesianGrid
                        strokeDasharray="3 3"
                    />

                    <XAxis
                        dataKey="name"
                    />

                    <YAxis />

                    <Tooltip />

                    <Bar
                        dataKey="amount"
                    />

                </BarChart>

            </ResponsiveContainer>

        </div>

    );
}

export default FinanceChart;