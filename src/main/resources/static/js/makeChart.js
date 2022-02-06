$(document).ready(function() {
    const makeChart = window.makeChart || {};
    window.makeChart = makeChart;

    let theChart = null;

    const colors = [
        "rgb(98, 171, 221)",
        "rgb(130, 143, 181)",
        "rgb(193, 228, 151)",
        "rgb(69, 111, 147)",
        "rgb(94, 60, 211)",
        "rgb(160, 205, 181)",
        "rgb(225, 106, 218)",
        "rgb(190, 130, 82)",
        "rgb(95, 69, 233)",
        "rgb(153, 176, 165)",
        "rgb(153, 69, 165)"
    ];

    function draw(datas, mfd, type) {

        const datasets = [
            {
                label: 'UCL',
                data:[],
                borderColor: "rgb(226, 0, 0)",
                pointStyle: 'line'
            },
            {
                label: 'LCL',
                data:[],
                borderColor: "rgb(226, 0, 0)",
                pointStyle: 'line'

            }
        ];

        if(type === 'BRACKET')
        {
            for (let i = 0; i < mfd.length; i++)
            {
                datasets[0].data.push(20200),
                datasets[1].data.push(11500)
            }
        }
        else
        {
            for (let i = 0; i < mfd.length; i++)
            {
                datasets[0].data.push(18100),
                datasets[1].data.push(11100)
            }
        }

        console.log('empty datasets');
        console.log(datasets); // 초기화를 하였는데 CP에 대한 값이 들어 있는 이유?

        const endForceByCp = {};
        let clamping_position;

        for (const item of datas) {
            for (const key in item) {
                if (key === 'cp') {
                    clamping_position = item[key];
                    if (endForceByCp[clamping_position]) {}
                    else {
                        endForceByCp[clamping_position] = [];
                    }
                }
                if (key === 'averageEndForceValue') {
                    endForceByCp[clamping_position].push(item[key])
                }
            }
        }

            for (const key in endForceByCp) {
                const label = key;
                const data = endForceByCp[key];

                datasets.push({
                    label: label, // cp
                    data: data, // end_force_values
                    borderColor: colors[datasets.length]
                })
            }

            console.log('fill datasets');
            console.log(datasets);

        const data = {
            labels: mfd,
            datasets: datasets
        };

        const config = {
            type: 'line',
            data: data,
            options: {
                maintainAspectRatio: true,
                responsive: false,
                scales: {
                    y: {
                        suggestedMin: 10000,
                        suggestedMax: 22000
                    }
                }
            }
        };

        if (theChart) {
            theChart.destroy();
        }

        theChart = new Chart(
            document.getElementById('myChart'),
            config
        );
    }
    makeChart.draw = draw;
})