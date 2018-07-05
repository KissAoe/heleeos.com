<style lang="less">
    @import '../../styles/common.less';
    @import './blog-flow.less';
</style>

<template>
    <div>
        <Row>
            <Card>
                <div class="step-header-con">
                    <h3>{{ stepData.title }}</h3>
                    <h5>{{ stepData.describe }}</h5>
                </div>
                <p class="step-content" v-html="stepData.content"></p>
                <Form class="step-form" ref="step" :model="step" :label-width="100">
                    <FormItem label="确认发布：" required>
                        <RadioGroup v-model="step.pass">
                            <Radio :disabled="submiting" label="发布"></Radio>
                            <Radio :disabled="submiting" label="不发布"></Radio>
                        </RadioGroup>
                    </FormItem>
                    <FormItem label="">
                        <Button :disabled="submiting" @click="handleSubmit" style="width:100px;" type="primary">提交</Button>
                    </FormItem>
                </Form>
                <Steps :current="currentStep" :status="status">
                    <Step v-for="item in stepList" :title="item.title" :content="item.content" :key="item.title"></Step>
                </Steps>
            </Card>
        </Row>
    </div>
</template>

<script>
export default {
    name: 'workflow',
    data () {
        return {
            stepList: [],
            stepData: {
                title: '',
                describe: '',
                content: ''
            },
            step: {
                pass: '发布'
            },
            submiting: false,
            currentStep: 0,
            status: 'wait'
        };
    },
    methods: {
        handleSubmit () {
            console.log("123");
            if (this.step.pass === '发布') {
                this.currentStep += 1;
            } else {
                this.status = 'error';
            }
            this.submiting = true;
        }
    },
    mounted () {
        this.stepList = [
            {
                title: '草稿发布',
                content: '张三'
            },
            {
                title: '文档审核',
                content: '李四'
            },
            {
                title: '线上公布',
                content: '李四'
            }
        ];
        this.stepData = {
            title: '七.一建党节庆祝活动申报',
            describe: '申报人：孙二',
            content: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据县委组织部(组织[20xx]21)文件通知精神，为纪念中国共产党建党xx周年，激励广大党员干部紧紧围绕党的群众路线教育主题，坚定理想信念，树立群众观点，增强服务意识，改进作风建设，夯实党的执政基础。经研究，决定在“七一”期间开展庆祝活动，现提出庆祝活动方案如下：</br> 　　一、活动主题 　　以中国特色社会主义理论为指导，深入贯彻落实党的十八大、十八届四中全会和习近平总书记系列讲话精神，紧紧围绕开展党的群众路线教育活动，以纪念建党xx周年为主题，广泛开展内容丰富、形式多样的纪念活动，通过形式多样、主题鲜明、广泛参与的庆祝活动，提升党组织的号召力、凝聚力和战斗力，使广大党员干部以更加饱满的热情迎接中国共产党成立xx周年。</br> 　　二、活动时间 　　6月下旬至7月</br> 　　三、活动安排 </br>　　1、组织党员开展一次集体学习活动。各党(总)支部要组织开展一次集体学习讨论，重点学习党的十八大、十八届四中全会精神、习近平总书记一系列重要讲话精神和习近平同志在兰考县委班子专题民主生活会时重要讲话精神为主要内容。引导大家开展深入全面的讨论，进一步把思想和行动统一到中央的决策部署上来，进一步把教育实践活动的作风建设成果，转化建设美丽铜陵县做贡献、当先锋的强大动力。</br> 　　2、开展一次党员领导干部带头上党课活动。各党(总)支部结合本支部情况，为庆祝党的生日，设计、组织好形式多样的党课活动，支部书记要带头上党课。要结合主题教育实践活动，一是认真落实为民务实清廉总要求，进一步改善党群、干群关系;二是要以反对“四风”为重点，切实改进作风;三是以提高执行力为重点，推动全县经济社会科学和谐跨越发展。</br> 　　3、开展一次走访慰问活动。结合正在开展的群众路线教育实践活动，各党总支部负责人要深入基层，对老党员、生活困难党员、离退休老干部、生产一线党员进行普遍慰问，切实增强基层党员荣誉感和归属感。</br> 　　4、开展一次调研走访活动。坚持领导带头、分级负责，扎实开展好调研走访活动。要真正坐下来，与职工群众面对面沟通、心贴心交流，听真话、访民意、摸实情，掌握第一手资料。要善于从基层单位存在的问题和面临的矛盾、困难中，反思自身工作存在的差距和不足。有条件的要安排部分费用，用于走访慰问老党员和生活困难党员。'
        };
        this.currentStep = 1;
    }
};
</script>
