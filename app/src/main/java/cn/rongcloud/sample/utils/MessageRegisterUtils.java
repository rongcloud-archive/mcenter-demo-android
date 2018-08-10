package cn.rongcloud.sample.utils;


import io.rong.imkit.RongIM;
import io.rong.mcenter.messages.MCCommunityHelpInfo;
import io.rong.mcenter.messages.MCInteractionAwaken;
import io.rong.mcenter.messages.MCInteractionComment;
import io.rong.mcenter.messages.MCInteractionFollowed;
import io.rong.mcenter.messages.MCInteractionLiked;
import io.rong.mcenter.messages.MCInteractionStartLive;
import io.rong.mcenter.messages.MCOfficialDiscountsExpire;
import io.rong.mcenter.messages.MCOfficialEvent;
import io.rong.mcenter.messages.MCOfficialHelpImgTxt;
import io.rong.mcenter.messages.MCOfficialHelpTxt;
import io.rong.mcenter.messages.MCOfficialMaintenance;
import io.rong.mcenter.messages.MCOfficialNews;
import io.rong.mcenter.messages.MCOfficialUpgrade;
import io.rong.mcenter.messages.MCOfficialWelcomeImgTxt;
import io.rong.mcenter.messages.MCOfficialWelcomeTxt;
import io.rong.mcenter.messages.MCTradingComment;
import io.rong.mcenter.messages.MCTradingNotPaid;
import io.rong.mcenter.messages.MCTradingOrderDistribution;
import io.rong.mcenter.messages.MCTradingOrderFailed;
import io.rong.mcenter.messages.MCTradingOrderProcessing;
import io.rong.mcenter.messages.MCTradingOrderSuccess;
import io.rong.mcenter.messages.MCTradingPaid;
import io.rong.mcenter.messages.MCWelfareGift;
import io.rong.mcenter.messages.MCWelfareRedPacket;
import io.rong.mcenter.messages.provider.MCCommunityHelpInfoProvider;
import io.rong.mcenter.messages.provider.MCInteractionAwakenProvider;
import io.rong.mcenter.messages.provider.MCInteractionCommentProvider;
import io.rong.mcenter.messages.provider.MCInteractionFollowedProvider;
import io.rong.mcenter.messages.provider.MCInteractionPraiseProvider;
import io.rong.mcenter.messages.provider.MCInteractionStartLiveProvider;
import io.rong.mcenter.messages.provider.MCOfficialDiscountsExpireProvider;
import io.rong.mcenter.messages.provider.MCOfficialEventProvider;
import io.rong.mcenter.messages.provider.MCOfficialHelpImgTxtProvider;
import io.rong.mcenter.messages.provider.MCOfficialHelpTxtProvider;
import io.rong.mcenter.messages.provider.MCOfficialNewsProvider;
import io.rong.mcenter.messages.provider.MCOfficialSysMaintenanceProvider;
import io.rong.mcenter.messages.provider.MCOfficialUpgradeProvider;
import io.rong.mcenter.messages.provider.MCOfficialWelcomeImgTxtProvider;
import io.rong.mcenter.messages.provider.MCOfficialWelcomeTxtProvider;
import io.rong.mcenter.messages.provider.MCTradingCommentProvider;
import io.rong.mcenter.messages.provider.MCTradingNotPaidProvider;
import io.rong.mcenter.messages.provider.MCTradingOrderDistributionProvider;
import io.rong.mcenter.messages.provider.MCTradingOrderFailedProvider;
import io.rong.mcenter.messages.provider.MCTradingOrderProcessingProvider;
import io.rong.mcenter.messages.provider.MCTradingOrderSuccessProvider;
import io.rong.mcenter.messages.provider.MCTradingPaidProvider;
import io.rong.mcenter.messages.provider.MCWelfareGiftProvider;
import io.rong.mcenter.messages.provider.MCWelfareRedPacketProvider;

public class MessageRegisterUtils {

    /**
     * 注册消息和消息模板
     */
    public static void registerMessages() {

        RongIM.registerMessageType(MCInteractionComment.class);
        RongIM.registerMessageTemplate(new MCInteractionCommentProvider());

        RongIM.registerMessageType(MCInteractionLiked.class);
        RongIM.registerMessageTemplate(new MCInteractionPraiseProvider());

        RongIM.registerMessageType(MCInteractionFollowed.class);
        RongIM.registerMessageTemplate(new MCInteractionFollowedProvider());

        RongIM.registerMessageType(MCWelfareGift.class);
        RongIM.registerMessageTemplate(new MCWelfareGiftProvider());

        RongIM.registerMessageType(MCWelfareRedPacket.class);
        RongIM.registerMessageTemplate(new MCWelfareRedPacketProvider());

        RongIM.registerMessageType(MCOfficialUpgrade.class);
        RongIM.registerMessageTemplate(new MCOfficialUpgradeProvider());

        RongIM.registerMessageType(MCOfficialEvent.class);
        RongIM.registerMessageTemplate(new MCOfficialEventProvider());

        RongIM.registerMessageType(MCOfficialMaintenance.class);
        RongIM.registerMessageTemplate(new MCOfficialSysMaintenanceProvider());

        RongIM.registerMessageType(MCOfficialWelcomeTxt.class);
        RongIM.registerMessageTemplate(new MCOfficialWelcomeTxtProvider());

        RongIM.registerMessageType(MCOfficialWelcomeImgTxt.class);
        RongIM.registerMessageTemplate(new MCOfficialWelcomeImgTxtProvider());

        RongIM.registerMessageType(MCOfficialHelpTxt.class);
        RongIM.registerMessageTemplate(new MCOfficialHelpTxtProvider());

        RongIM.registerMessageType(MCOfficialHelpImgTxt.class);
        RongIM.registerMessageTemplate(new MCOfficialHelpImgTxtProvider());

        RongIM.registerMessageType(MCInteractionStartLive.class);
        RongIM.registerMessageTemplate(new MCInteractionStartLiveProvider());

        RongIM.registerMessageType(MCCommunityHelpInfo.class);
        RongIM.registerMessageTemplate(new MCCommunityHelpInfoProvider());

        RongIM.registerMessageType(MCInteractionAwaken.class);
        RongIM.registerMessageTemplate(new MCInteractionAwakenProvider());

        RongIM.registerMessageType(MCOfficialDiscountsExpire.class);
        RongIM.registerMessageTemplate(new MCOfficialDiscountsExpireProvider());

        RongIM.registerMessageType(MCOfficialNews.class);
        RongIM.registerMessageTemplate(new MCOfficialNewsProvider());

        RongIM.registerMessageType(MCTradingComment.class);
        RongIM.registerMessageTemplate(new MCTradingCommentProvider());

        RongIM.registerMessageType(MCTradingNotPaid.class);
        RongIM.registerMessageTemplate(new MCTradingNotPaidProvider());

        RongIM.registerMessageType(MCTradingOrderDistribution.class);
        RongIM.registerMessageTemplate(new MCTradingOrderDistributionProvider());

        RongIM.registerMessageType(MCTradingOrderFailed.class);
        RongIM.registerMessageTemplate(new MCTradingOrderFailedProvider());

        RongIM.registerMessageType(MCTradingOrderProcessing.class);
        RongIM.registerMessageTemplate(new MCTradingOrderProcessingProvider());

        RongIM.registerMessageType(MCTradingOrderSuccess.class);
        RongIM.registerMessageTemplate(new MCTradingOrderSuccessProvider());

        RongIM.registerMessageType(MCTradingPaid.class);
        RongIM.registerMessageTemplate(new MCTradingPaidProvider());
    }
}
